package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoard(){
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "TrelloBoard Name", new ArrayList<>()));

        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoard(trelloBoardDtos);

        assertAll(
                () -> assertEquals(trelloBoardList.get(0).getId(), trelloBoardDtos.get(0).getId()),
                () -> assertEquals(trelloBoardList.get(0). getName(), trelloBoardDtos.get(0).getName()),
                () -> assertEquals(trelloBoardList.get(0).getLists(), trelloBoardDtos.get(0).getLists()),
                () -> assertEquals(1, trelloBoardList.size()),
                () -> assertEquals(1, trelloBoardDtos.size())
        );

    }

    @Test
    void testMapToBoardsDto(){
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "TrelloBoard Name", new ArrayList<>()));

        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoards);

        assertAll(
                () -> assertEquals(trelloBoardDtoList.get(0).getId(), trelloBoards.get(0).getId()),
                () -> assertFalse(trelloBoardDtoList.isEmpty()),
                () -> assertFalse(trelloBoards.isEmpty())
        );
    }

    @Test
    void testMapToList(){
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "Name", false));

        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);

        assertAll(
                () -> assertEquals(trelloList.get(0).getId(), trelloList.get(0).getId()),
                () -> assertFalse(trelloList.isEmpty()),
                () -> assertFalse(trelloListDto.isEmpty())
        );

    }

    @Test
    void testMapToListDto(){
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "name", false));

        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);

        assertAll(
                () -> assertEquals(trelloListDto.get(0).getId(), trelloList.get(0).getId()),
                () -> assertFalse(trelloListDto.isEmpty()),
                () -> assertFalse(trelloList.isEmpty())
        );

    }

    @Test
    void testMapToCardDto(){
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");

        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        assertAll(
                () -> assertEquals(trelloCardDto.getName(), trelloCard.getName()),
                () -> assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription()),
                () -> assertEquals(trelloCardDto.getPos(), trelloCard.getPos()),
                () -> assertEquals(trelloCardDto.getListId(), trelloCard.getListId())
        );
    }

    @Test
    void testMapToCard(){
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");

        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        assertAll(
                () -> assertEquals(trelloCard.getName(), trelloCardDto.getName()),
                () -> assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription()),
                () -> assertEquals(trelloCard.getPos(), trelloCardDto.getPos()),
                () -> assertEquals(trelloCard.getListId(), trelloCardDto.getListId())
        );
    }

}