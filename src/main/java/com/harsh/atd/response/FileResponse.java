package com.harsh.atd.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {
    private List<String> files;
    private Integer totalFiles;
}
