package it.altagem.firsttestviewadapter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class MainActivityTest {

    @Mock private MainViewI mView;
    @Mock private MainActivity mActivity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void shouldLoadDataPage() throws Exception {
        mActivity.loadDataPage();
        verify(mView).loadDataPage();
    }
}