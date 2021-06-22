package com.redisgeek.function.acre.imports;

import com.azure.core.credential.TokenCredential;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.AzureAuthorityHosts;
import com.azure.identity.EnvironmentCredentialBuilder;
import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.redisenterprise.RedisEnterpriseManager;
import com.azure.resourcemanager.redisenterprise.models.Cluster;
import com.azure.resourcemanager.redisenterprise.models.Database;
import com.azure.resourcemanager.redisenterprise.models.ImportClusterParameters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Import implements Function<String, String> {

    @Value("${acre_id}")
    private String acre_id;

    @Value("${blobSas}")
    private String blobSas;

    @Value("${storageKey}")
    private String storageKey;

    @Value("${storageAccountName}")
    private String storageAccountName;

    static String sourceContainerName = "redisgeek-target";

    public String apply(String trigger) {
        try {
            TokenCredential credential = new EnvironmentCredentialBuilder()
                    .authorityHost(AzureAuthorityHosts.AZURE_PUBLIC_CLOUD)
                    .build();
            AzureProfile profile = new AzureProfile(AzureEnvironment.AZURE);
            RedisEnterpriseManager redisEnterpriseManager = RedisEnterpriseManager
                    .authenticate(credential, profile);
            AzureResourceManager azure = AzureResourceManager
                    .authenticate(credential, profile)
                    .withDefaultSubscription();
            String resourceGroupName = azure.genericResources().getById(acre_id).resourceGroupName();
            Cluster cluster = redisEnterpriseManager.redisEnterprises().getById(acre_id);
            Database database = redisEnterpriseManager.databases().getById(acre_id + "/databases/default");
            String blobSasUri = String.format("https://%s.blob.core.windows.net/%s%s", storageAccountName, sourceContainerName, blobSas);
            ImportClusterParameters importClusterParameters =
                    new ImportClusterParameters().withSasUri(blobSasUri + ";" + storageKey);
            importClusterParameters.validate();

            redisEnterpriseManager
                    .databases()
                    .importMethod(resourceGroupName,
                            cluster.name(),
                            database.name(),
                            importClusterParameters);
            return "Import Complete";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}