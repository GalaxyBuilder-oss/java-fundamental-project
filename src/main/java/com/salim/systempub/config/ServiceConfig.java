package com.salim.systempub.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.salim.systempub.repositories.AuthRepository;
import com.salim.systempub.repositories.GenerationRepository;
import com.salim.systempub.repositories.MemberPaggingRepository;
import com.salim.systempub.repositories.MemberRepository;
import com.salim.systempub.repositories.chamberlain.ChamberlainRepository;
import com.salim.systempub.repositories.chamberlain.PUBBalanceRepository;
import com.salim.systempub.repositories.divitionrepository.divkeasramaan.MemberDivKeasramaanRepository;
import com.salim.systempub.repositories.divitionrepository.divkeasramaan.MemberDormitoryRepository;
import com.salim.systempub.repositories.divitionrepository.divkebersihan.MemberDivKebersihanRepository;
import com.salim.systempub.repositories.divitionrepository.divkebersihan.PiketRepository;
import com.salim.systempub.repositories.divitionrepository.divkerohanian.DataPUBRepository;
import com.salim.systempub.repositories.divitionrepository.divkerohanian.MemberDivkerohanianRepository;
import com.salim.systempub.repositories.divitionrepository.divkesehatan.FarmacyRepository;
import com.salim.systempub.repositories.divitionrepository.divkesehatan.MemberDivKesehatanRepository;
import com.salim.systempub.repositories.divitionrepository.divkesejahteraan.MemberDivKesejahteraanRepository;
import com.salim.systempub.repositories.divitionrepository.divpelatihaninggris.MemberDivPelatihanInggrisRepository;
import com.salim.systempub.repositories.divitionrepository.divpelatihaninggris.VocabRepository;
import com.salim.systempub.repositories.divitionrepository.divpendidikan.KelompokRepository;
import com.salim.systempub.repositories.divitionrepository.divpendidikan.MemberDivPendidikanRepository;
import com.salim.systempub.repositories.divitionrepository.divpendidikan.MemberGroupRepository;
import com.salim.systempub.repositories.ppmb.PPMBRepository;
import com.salim.systempub.repositories.secretary.SecretaryRepository;

public class ServiceConfig {

    @Autowired
    public AuthRepository authRepository;

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public GenerationRepository generationRepository;

    @Autowired
    public MemberPaggingRepository memberPaggingRepository;

    @Autowired
    public PPMBRepository ppmbRepository;
    
    @Autowired
    public MemberDormitoryRepository memberDormitoryRepository;

    @Autowired
    public MemberDivKeasramaanRepository memberDivKeasramaanRepository;

    @Autowired
    public MemberDivKebersihanRepository memberDivKebersihanRepository;

    @Autowired
    public PiketRepository piketRepository;

    @Autowired
    public DataPUBRepository dataPUBRepository;

    @Autowired
    public MemberDivkerohanianRepository memberDivkerohanianRepository;

    @Autowired
    public FarmacyRepository farmacyRepository;

    @Autowired
    public MemberDivKesehatanRepository memberDivKesehatanRepository;

    @Autowired
    public MemberDivKesejahteraanRepository memberDivKesejahteraanRepository;

    @Autowired
    public MemberDivPelatihanInggrisRepository memberDivPelatihanInggrisRepository;

    @Autowired
    public VocabRepository vocabRepository;

    @Autowired
    public KelompokRepository kelompokRepository;

    @Autowired
    public MemberDivPendidikanRepository memberDivPendidikanRepository;

    @Autowired
    public MemberGroupRepository memberGroupRepository;

    @Autowired
    public ChamberlainRepository chamberlainRepository;
    
    @Autowired
    public PUBBalanceRepository pubBalanceRepository;

    @Autowired
    public SecretaryRepository secretaryRepository;

}