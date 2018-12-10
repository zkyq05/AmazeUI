package com.xh.springBoot.domain;

import com.xh.springBoot.modle.Player;
import com.xh.springBoot.modle.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
