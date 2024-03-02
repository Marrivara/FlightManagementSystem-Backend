package com.company.organization.backend.requests.entityRequests;

import com.company.organization.backend.model.enums.AirplaneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneRequest {

    private AirplaneType airplaneType;
    private Integer capacity;
    private Integer locationId;
    private Integer airlineCompanyId;
}
