package icu.samnyan.aqua.sega.maimai2.dao.userdata;

import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.maimai2.model.userdata.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Repository("Maimai2UserDataRepository")
public interface UserDataRepository extends JpaRepository<UserDetail, Long> {

    Optional<UserDetail> findByCard(Card card);

    Optional<UserDetail> findByCard_ExtId(long userId);

    @Transactional
    void deleteByCard(Card card);

    @Query("select count(*) from Maimai2UserData where playerRating > :rating")
    Integer getRanking(int rating);
}
