package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean doCategoriesExist(List<Long> categoryIds) {
        return categoryIds.stream().allMatch(foodCategoryRepository::existsById);
    }
}
