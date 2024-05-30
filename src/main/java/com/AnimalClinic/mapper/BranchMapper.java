package com.AnimalClinic.mapper;

import com.AnimalClinic.dto.BranchDto;
import com.AnimalClinic.entity.Branch;

public class BranchMapper {

    public static BranchDto convert(Branch branch) {
        return BranchDto.builder()
                .name(branch.getName())
                .build();
    }
}
