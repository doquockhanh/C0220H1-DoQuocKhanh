package service.Implement;

import org.springframework.stereotype.Service;
import service.FindWord;

import java.util.Map;
import java.util.TreeMap;

@Service
public class FindWordIml implements FindWord {
    @Override
    public String find(String found) {
        Map<String, String> lib = new TreeMap<>();
        lib.put("hello", "xin chao");
        lib.put("book", "sach");
        if (lib.containsKey(found)){
            return lib.get(found);
        }else return "khong tim thay tu";
    }
}
