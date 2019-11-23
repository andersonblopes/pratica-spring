package com.lopes.foto.exception;

import java.io.IOException;

public class UploadArquivoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;

    public UploadArquivoException(String msg) {
        this.msg = msg;
    }

    public UploadArquivoException(String msg, IOException e) {
        this.msg = msg;
        e.printStackTrace();
    }

    public String getMsg() {
        return msg;
    }
}
