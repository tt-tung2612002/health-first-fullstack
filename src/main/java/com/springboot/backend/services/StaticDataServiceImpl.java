package com.springboot.userservice.services;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.userservice.dto.response.*;
import com.springboot.userservice.entity.*;
import com.springboot.userservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StaticDataServiceImpl implements StaticDataService {

    @PersistenceContext
    private final EntityManager entityManager;

    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final WardRepository wardRepository;
    private final FoodRepository foodRepository;
    private final InspectionUnitRepository inspectionUnitRepository;

    public List<ProvinceResponseDto> testBenchmarkMethod1() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QProvince qProvince = QProvince.province;
        List<Province> provinces = queryFactory.selectFrom(qProvince).fetch();
        return provinces.stream().map(ProvinceResponseDto::new).collect(Collectors.toList());
    }

    public List<ProvinceResponseDto> testBenchmarkMethod2() {
        return provinceRepository.findAll(Sort.by(Sort.Direction.ASC,
                "id")).stream().map(ProvinceResponseDto::new).collect(Collectors.toList());
    }

    public List<ProvinceResponseDto> getProvinces() {
        return provinceRepository.findAll(Sort.by(Sort.Direction.ASC,
                "id")).stream().map(ProvinceResponseDto::new).collect(Collectors.toList());

    }

    public List<DistrictResponseDto> getDistrictsByProvince(int provinceId) {
        return districtRepository.findAllByProvince(provinceRepository.findById(provinceId)).stream()
                .map(DistrictResponseDto::new)
                .collect(Collectors.toList());

    }

    @Override
    public List<WardResponseDto> getWardsByDistrict(int districtId) {
        return wardRepository.findAllByDistrict(districtRepository.findById(districtId)).stream()
                .map(WardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodResponseDto> getFoods() {
        return foodRepository.findAll().stream().map(FoodResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public List<InspectionUnitResponseDto> getInspectionUnits() {
        return inspectionUnitRepository.findAll().stream().map(InspectionUnitResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public InspectionUnit getInspectionUnitById(int id) {
        return inspectionUnitRepository.findById(id);
    }

    @Override
    public Food getFoodById(int id) {
        return foodRepository.findById(id);
    }

    @Override
    public Province getProvinceById(int provinceId) {
        return provinceRepository.findById(provinceId);
    }

    @Override
    public District getDistrictById(int districtId) {
        return districtRepository.findById(districtId);
    }

    @Override
    public Ward getWardById(int wardId) {
        return wardRepository.findById(wardId);
    }

}