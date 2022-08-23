package com.hwe.helloworldenterprise.service.impl;

import com.hwe.helloworldenterprise.entity.Enterprise;

import com.hwe.helloworldenterprise.repository.IEnterpriseDAO;
import com.hwe.helloworldenterprise.service.IEntepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl implements IEntepriseService {

    @Autowired
    private IEnterpriseDAO enterpriseDAO;

    @Override
    public boolean delete(Long id) {
        try {
            enterpriseDAO.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Enterprise save(Enterprise enterprise) {

        return enterpriseDAO.save(enterprise);
    }

    @Override
    public List<Enterprise> findAll() {

        return enterpriseDAO.findAll();
    }

    @Override
    public Enterprise findById(Long id) {
        return enterpriseDAO.findById(id).get();
    }
}
