package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.ReviewImageConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.CreateDto request){

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new IllegalArgumentException("해당 id를 가진 가게가 없습니다."));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Review review = ReviewConverter.toReview(request);
        review.setStore(store);
        review.setMember(member);

        List<ReviewImage> reviewImages = ReviewImageConverter.toReviewImageList(request.getReviewImageList(), review);
        review.getReviewImageList().addAll(reviewImages);

        return reviewRepository.save(review);
    }

}
