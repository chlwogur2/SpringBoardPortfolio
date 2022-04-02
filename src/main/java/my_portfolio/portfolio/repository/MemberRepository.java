package my_portfolio.portfolio.repository;

import my_portfolio.portfolio.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
