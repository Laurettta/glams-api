package com.glams.service.serviceImpl;

import com.glams.dto.request.NotificationRequestDTO;
import com.glams.dto.response.NotificationResponseDTO;
import com.glams.mapper.NotificationMapper;
import com.glams.model.Notification;
import com.glams.model.User;
import com.glams.repository.NotificationRepository;
import com.glams.repository.UserRepository;
import com.glams.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationResponseDTO create(NotificationRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Notification notification = notificationMapper.toEntity(dto);
        notification.setUser(user);

        Notification saved = notificationRepository.save(notification);
        return notificationMapper.toDto(saved);
    }

    @Override
    public NotificationResponseDTO getById(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        return notificationMapper.toDto(notification);
    }

    @Override
    public List<NotificationResponseDTO> getAll() {
        return notificationRepository.findAll()
                .stream()
                .map(notificationMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}
