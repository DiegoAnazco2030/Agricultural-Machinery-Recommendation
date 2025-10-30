package org.flys.services.DTOs;

import java.util.Objects;

public class FlyDeleteDTO {
    private final String id;
    private final String reason;     // opcional: motivo de eliminación
    private final String requestedBy; // opcional: quién solicita

    public FlyDeleteDTO(String id) {
        this(id, null, null);
    }

    public FlyDeleteDTO(String id, String reason, String requestedBy) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.reason = reason;
        this.requestedBy = requestedBy;
    }

    public String getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    @Override
    public String toString() {
        return "FlyDeleteDTO{id='" + id + '\'' +
            (reason != null ? ", reason='" + reason + '\'' : "") +
            (requestedBy != null ? ", requestedBy='" + requestedBy + '\'' : "") +
            '}';
    }
}