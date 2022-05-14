package com.example.test1.service;

import com.example.test1.bean.Test;
import com.example.test1.dao.TestDao;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Imprimer {

    public int save(Test test){
        testDao.save(test);
        return 1;
    }


    public List<Test> findAll() {
        return testDao.findAll();
    }

    public Test findByCode(String code) {
        return testDao.findByCode(code);
    }

    public String imprimer(String code) throws FileNotFoundException, JRException {
        List<Test> test=findAll();
        Test test1=findByCode(code);

        File file = ResourceUtils.getFile("classpath:test.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource datesource = new JRBeanCollectionDataSource(test);
        Map<String, Object> parametres = new HashMap<String, Object>();
        parametres.put("salaire","1200" );
        parametres.put("username", test1.getLibelle());
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parametres, datesource);

        JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Hp\\Desktop" + "\\Test1"+test1.getId()+".pdf");
        return "hahahah";
    }
    @Autowired
    TestDao testDao;
}
