package com.tugas.pertemuan13.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tugas.pertemuan13.models.Buku;
import com.tugas.pertemuan13.repository.BukuRepository;

@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    public String showAll(Model model) {
        if (!bukuRepository.findAll().isEmpty()) {
            model.addAttribute("all", bukuRepository.findAll());
            return "index";
        } else {
            model.addAttribute("allNull", null);
            return "redirect:/add";
        }
    }

    public String add(Model model) {
        Buku book = new Buku();
        model.addAttribute("add", book);
        return "add";
    }

    public String save(Buku buku, Model model) {
        List<Buku> books = bukuRepository.findAll();
        boolean isThere = false;
        for (Buku bo : books) {
            if (bo.getCode().equals(buku.getCode())) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            // bukuRepository.save(buku);
            // return "redirect:/";
            model.addAttribute("errormessage", "Data Telah Ada, Masukan Data Lain");
            return "redirect:/error";
        } else {
            bukuRepository.save(buku);
            return "redirect:/";
        }
    }

    public String delete(Long id, Model model) {
        List<Buku> books = bukuRepository.findAll();
        boolean isThere = false;
        for (Buku bo : books) {
            if (id == bo.getId()) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            bukuRepository.deleteById(id);
            return "redirect:/";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "redirect:/error";
        }
    }

    public String update(Long id, Model model) {
        List<Buku> books = bukuRepository.findAll();
        Buku buku = bukuRepository.getReferenceById(id);
        boolean isThere = false;
        for (Buku bo : books) {
            if (id == bo.getId()) {
                isThere = true;
                break;
            }
        }
        if (isThere) {
            model.addAttribute("update", buku);
            return "update";
        } else {
            model.addAttribute("errormessage", "Data Tidak Ada, Masukan Data Lain");
            return "redirect:/error";
        }
    }

    public String saveUpdate(Buku buku) {
        try {
            bukuRepository.save(buku);
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return "redirect:/";
    }
    public String find(String nama, Model model) {
        List<Buku> b = bukuRepository.findAll();
        List<Buku> b2 = new ArrayList<>();
        for (Buku buku : b) {
            if (buku.getName().contains(nama.replace("nama=",""))) {
                b2.add(buku);
            }
        }
        model.addAttribute("all",b2);
        return "/index";
    }
}
