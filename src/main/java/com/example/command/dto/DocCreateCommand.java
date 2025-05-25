package com.example.command.dto;

import java.util.UUID;

public record DocCreateCommand(UUID docId, String body) {}
