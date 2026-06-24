package entity;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class Auditoria {

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

        private String createdBy;

        private String updatedBy;

    }

