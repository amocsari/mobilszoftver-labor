package com.example.hbr.presenter;

import com.example.hbr.respository.web.Webservice;
import com.example.hbr.view.IBookListView;

import javax.inject.Inject;

public class BookListPresenter extends PresenterBase<IBookListView> {
    @Inject
    Webservice webservice;
}
