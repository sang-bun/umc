package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreServise {

    private final StoreRepository storeRepository;

    public boolean existById(Long id) {
        return storeRepository.existsById(id);
    }
}
