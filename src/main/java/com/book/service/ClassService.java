package com.book.service;

import com.book.dao.ClassDao;
import com.book.domain.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassService {
    @Resource
    private ClassDao classDao;

    public List<ClassInfo> list() {
        return classDao.getAll();
    }
}
