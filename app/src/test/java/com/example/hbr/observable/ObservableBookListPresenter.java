package com.example.hbr.observable;

import com.example.hbr.adapter.BookListAdapter;
import com.example.hbr.mocks.MockFactory;
import com.example.hbr.presenter.BookListPresenter;

public class ObservableBookListPresenter extends BookListPresenter {
    public ObservableBookListPresenter() {
        remoteListAdapter = MockFactory.mockRemoteBookListAdapter;
        localListAdapter = MockFactory.mockLocalBookListAdapter;
    }
}
