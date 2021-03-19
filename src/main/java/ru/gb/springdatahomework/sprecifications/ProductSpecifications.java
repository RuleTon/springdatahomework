package ru.gb.springdatahomework.sprecifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.gb.springdatahomework.model.Product;

public class ProductSpecifications {
    private static Specification<Product> costHighorEqual (int minCost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), minCost);

    }

    private static Specification<Product> costLessorEqual(int maxCost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), maxCost);
    }

    private static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"),String.format("%%%s%%",titlePart));
    }

    public static Specification<Product> build(MultiValueMap<String,String> params) {
        Specification<Product> spec = Specification.where(null);
        if (params.containsKey("min_cost") && !params.getFirst("min_cost").isBlank()) {
            spec = spec.and((ProductSpecifications.costHighorEqual(Integer.parseInt(params.getFirst("min_cost")))));
        }

        if (params.containsKey("max_cost") && !params.getFirst("max_cost").isBlank()) {
            spec = spec.and((ProductSpecifications.costLessorEqual(Integer.parseInt(params.getFirst("max_cost")))));
        }

        if (params.containsKey("title") && !params.getFirst("title").isBlank()) {
            spec = spec.and(ProductSpecifications.titleLike(params.getFirst("title")));
        }
        return spec;
    }


}
