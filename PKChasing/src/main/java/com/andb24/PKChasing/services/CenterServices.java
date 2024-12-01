package com.andb24.PKChasing.services;

import com.andb24.PKChasing.dto.CenterDto;
import com.andb24.PKChasing.models.Center;

public interface CenterServices {
    CenterDto mapToCenterDto(Center center);
    Center mapToCenter(CenterDto centerDto);
}
