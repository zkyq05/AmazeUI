package com.xh.springBoot.domain;

import com.xh.springBoot.modle.Player;
import com.xh.springBoot.modle.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
