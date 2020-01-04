package com.cake.services;

import com.cake.entities.Cake;
import com.cake.exceptions.CustomException;
import com.cake.repositories.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CakeService {

    private CakeRepository cakeRepo = null;

    @Autowired
    CakeService(CakeRepository cakeRepo) {
        this.cakeRepo = cakeRepo;
    }

    public List<Cake> getAllCakes() {
        List<Cake> cakes = null;

        try {
            cakes = cakeRepo.findAll();
        } catch (Exception e) {
            throw new CustomException("A problem happened.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return cakes;
    }

    public Cake getCakeById(long id) {
        Optional<Cake> cake = null;

        try {
            cake = cakeRepo.findById(id);
        } catch (Exception e) {
            throw new CustomException("A problem happened.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return cake.isPresent() ? cake.get() : null;
    }

    public Cake insertCake(Cake cake) {

        try {
            if(cakeRepo.findByTitle(cake.getTitle()).isPresent()) throw new CustomException("This cake already exist.", HttpStatus.BAD_REQUEST);
            cake = cakeRepo.saveAndFlush(cake);
        } catch (CustomException e) {
            throw e;
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("This cake already exist.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("A problem happened while registering the cake", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return cake;
    }

    public Cake updateCake(Cake cake) {
        try {
            Optional<Cake> cakeOp = cakeRepo.findByTitle(cake.getTitle());
            if(!cakeOp.isPresent()) throw new CustomException("This cake does not exist.", HttpStatus.BAD_REQUEST);
            cake.setId(cakeOp.get().getId());
            cake.set_createdAt(cakeOp.get().get_createdAt());
            cake = cakeRepo.saveAndFlush(cake);
        } catch (CustomException e) {
            throw e;
        } catch (DataIntegrityViolationException e) {
            throw new CustomException("Data Integrity violation.", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new CustomException("A problem happened while registering the user", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return cake;
    }


}
