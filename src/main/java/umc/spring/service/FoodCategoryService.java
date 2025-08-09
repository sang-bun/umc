package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsAllById(List<Long> Ids){
        return Ids.stream()
                .allMatch(value -> foodCategoryRepository.existsById(value));
    }
}
