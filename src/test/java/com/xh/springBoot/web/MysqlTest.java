package com.xh.springBoot.web;

import com.xh.springBoot.MyApplication;
import com.xh.springBoot.domain.PositionRepository;
import com.xh.springBoot.domain.TeamRepository;
import com.xh.springBoot.modle.Player;
import com.xh.springBoot.domain.PlayerRepository;
import com.xh.springBoot.modle.Position;
import com.xh.springBoot.modle.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MyApplication.class})
@Rollback(value = true)
//@Transactional(transactionManager = "transactionManager")
public class MysqlTest {
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PositionRepository positionRepository;

    @Before
    public void initData(){
//        playerRepository.deleteAll();
//        positionRepository.deleteAll();
//        teamRepository.deleteAll();

        Team team = new Team();
        team.setName("湖人队");
        teamRepository.save(team);
        Assert.assertNotNull(team.getId());

        Position position = new Position();
        position.setName("SG");
        positionRepository.save(position);
        Assert.assertNotNull(position.getId());

        Player player = new Player();
        player.setName("Kobe Bryant");
        player.setCreatedate(new Date());
        player.setTeam(team);
        List<Position> positions = positionRepository.findAll();
        Assert.assertNotNull(positions);
        player.setPosition(positions);

        playerRepository.save(player);
        Assert.assertNotNull(player.getId());
    }

    @Test
    public void findPage(){
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<Player> page = playerRepository.findAll(pageable);
        Assert.assertNotNull(page);

        for(Player player: page.getContent()){
            logger.info("\n========player======== player name:{}, team name:{}, position name:{}\n",
                    player.getName(), player.getTeam().getName(), player.getPositions().get(0).getName());
        }
    }
}
