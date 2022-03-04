package itmo.coursework.impl;

import itmo.coursework.repository.PositionRepository;
import itmo.coursework.repository.StaffRepository;
import itmo.coursework.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final PositionRepository positionRepository;
}
