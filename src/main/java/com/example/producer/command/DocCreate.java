package com.example.producer.command;

import java.util.UUID;

public record DocCreate(UUID docId, String body) {}
