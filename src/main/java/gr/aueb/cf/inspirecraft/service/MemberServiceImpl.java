package gr.aueb.cf.inspirecraft.service;

import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectAlreadyExistsException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectInvalidArgumentException;
import gr.aueb.cf.inspirecraft.core.exceptions.AppObjectNotFoundException;
import gr.aueb.cf.inspirecraft.dto.MemberInsertDTO;
import gr.aueb.cf.inspirecraft.dto.MemberReadOnlyDTO;
import gr.aueb.cf.inspirecraft.dto.MemberUpdateDTO;
import gr.aueb.cf.inspirecraft.mapper.MemberMapper;
import gr.aueb.cf.inspirecraft.model.Creator;
import gr.aueb.cf.inspirecraft.model.Favorites;
import gr.aueb.cf.inspirecraft.model.Member;
import gr.aueb.cf.inspirecraft.model.Product;
import gr.aueb.cf.inspirecraft.repositories.FavoritesRepository;
import gr.aueb.cf.inspirecraft.repositories.MemberRepository;
import gr.aueb.cf.inspirecraft.repositories.ProductRepository;
import gr.aueb.cf.inspirecraft.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IMemberService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final MemberMapper memberMapper;
    private final FavoritesRepository favoritesRepository;


    @Override
    public MemberReadOnlyDTO saveMember(MemberInsertDTO memberInsertDTO) throws AppObjectAlreadyExistsException, AppObjectInvalidArgumentException {

        if (memberRepository.findById(memberInsertDTO.getUser().getId()).isPresent()){
            throw new AppObjectAlreadyExistsException("Member", "Member already exists");
        }
        if (userRepository.findByUsername(memberInsertDTO.getUser().getUsername()).isPresent()){
            throw new AppObjectAlreadyExistsException("Member", "Member already exists");
        }

        Member member = memberMapper.mapToMemberEntity(memberInsertDTO);
        Member savedMember = memberRepository.save(member);
        return memberMapper.mapToMemberReadOnlyDTO(savedMember);

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public MemberReadOnlyDTO updateMember(MemberUpdateDTO memberUpdateDTO) throws AppObjectInvalidArgumentException, AppObjectNotFoundException {
        if (userRepository.findById(memberUpdateDTO.getUser().getId()).isEmpty()){
            throw new AppObjectNotFoundException("Creator", "Creator not found");
        }

        Member member = memberMapper.mapToMemberEntity(memberUpdateDTO);
        Member savedMember = memberRepository.save(member);
        return memberMapper.mapToMemberReadOnlyDTO(savedMember);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteMember(Long id) throws AppObjectNotFoundException {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Product> getFavoriteProductsByMemberId(Long id) { //todo
        return  null;
    }

    @Override
    public void addProductToFavorites(Long memberId, Long productId) { //todo

    }

    @Override
    public void removeProductFromFavorites(Long memberId, Long productId) { //todo

    }
}
