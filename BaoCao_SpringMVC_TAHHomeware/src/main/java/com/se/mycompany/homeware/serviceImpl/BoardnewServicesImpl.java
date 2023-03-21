package com.se.mycompany.homeware.serviceImpl;

import com.se.mycompany.homeware.dao.BoardnewDao;
import com.se.mycompany.homeware.daoImpl.BoardnewDaoImpl;
import com.se.mycompany.homeware.model.Boardnew;
import com.se.mycompany.homeware.service.BoardnewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardnewServicesImpl implements BoardnewService {

    @Autowired
    BoardnewDao boardnewDao = new BoardnewDaoImpl();

    @Override
    public void insert(Boardnew boardnew) {
        // TODO Auto-generated method stub
        boardnewDao.insert(boardnew);
    }

    @Override
    public void edit(Boardnew newBoardnew) {
        // TODO Auto-generated method stub
        Boardnew oldBoardnew = boardnewDao.get((newBoardnew.getId()));
        System.out.println("xem thử có chưa " + oldBoardnew);
        oldBoardnew.setTitle(newBoardnew.getTitle());
        oldBoardnew.setContent(newBoardnew.getContent());
        oldBoardnew.setImage_link(newBoardnew.getImage_link());
        oldBoardnew.setAuthor(newBoardnew.getAuthor());
        oldBoardnew.setCreated(newBoardnew.getCreated());
        boardnewDao.edit(oldBoardnew);
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        boardnewDao.delete(id);
    }

    @Override
    public Boardnew get(int id) {
        return boardnewDao.get(id);
    }

    @Override
    @Transactional
    public Boardnew get(String name) {
        return boardnewDao.get(name);
    }

    @Override
    @Transactional
    public List<Boardnew> getAll() {
        return boardnewDao.getAll();
    }

}
