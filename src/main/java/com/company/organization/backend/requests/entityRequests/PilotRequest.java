package com.company.organization.backend.requests.entityRequests;

import com.company.organization.backend.model.enums.AirplaneType;
import com.company.organization.backend.model.enums.Gender;
import com.company.organization.backend.model.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PilotRequest {

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private Integer age;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private List<AirplaneType> airplaneLicences;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer airlineCompanyId;
}
