package com.datamask.datamask_api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncryptController {

    private final EncryptionService encryptionService;

    // Spring injecte automatiquement le service (Dependency Injection)
    public EncryptController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String data) throws Exception {
        return encryptionService.encrypt(data);
    }
}