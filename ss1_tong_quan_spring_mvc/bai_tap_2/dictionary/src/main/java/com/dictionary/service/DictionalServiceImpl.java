package com.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionalServiceImpl implements IDictionalService {
    @Override
    public String searchDictional(String search) {
        String value = "";
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("hello", "xin chào");
        stringMap.put("sport", "thể thao");
        stringMap.put("Shoe", "Giày");
        stringMap.put("Salary", "Lương");
        stringMap.put("telephone", "điện thoại");
        stringMap.put("supermarket", "siêu thị");
        stringMap.put("tree", "cây");
        stringMap.put("volleyball", "bóng chuyền");
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            if (search.equals(entry.getKey())) {
                value = entry.getValue();
            }

        }return value;
    }
}
