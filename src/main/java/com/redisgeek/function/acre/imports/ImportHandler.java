package com.redisgeek.function.acre.imports;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

public class ImportHandler extends FunctionInvoker<byte[], String> {

    @FunctionName("ImportRDB")
    public void run(
            @BlobTrigger(name = "file",
                    dataType = "binary",
                    path = "redisgeek-target/export.rdb.gz",
                    connection = "AzureWebJobsStorage") byte[] content,
            @BindingName("name") String filename,
            final ExecutionContext context
    ) {
        context.getLogger().info("Name: " + filename + " Size: " + content.length + " bytes");
        context.getLogger().info("Function Result :::" + handleRequest(content, context));
    }
}
