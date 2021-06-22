package com.redisgeek.function.acre.imports;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class ImportHandler extends FunctionInvoker<Optional<String>, String> {

    @FunctionName("CopyBlob")
    public void run(
            @BlobTrigger(name = "file",
                    dataType = "binary",
                    path = "primaryeohh/{name}.rdb.gz",
                    connection = "AzureWebJobsStorage") byte[] content,
            @BindingName("name") String filename,
            final ExecutionContext context
    ) {
        context.getLogger().info("Name: " + filename + " Size: " + content.length + " bytes");
        context.getLogger().info("Import file to secondary instance");
        context.getLogger().info("Delete file from container");
    }
}
