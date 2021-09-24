package com.adamfgcross.unittesting.business;

import com.adamfgcross.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BusinessImplTest {

    @Test
    public void calculateSum_basic() {
        BusinessImpl businessImpl = new BusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_emptyArray() {
        BusinessImpl businessImpl = new BusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_dataService_basic() {
        BusinessImpl businessImpl = new BusinessImpl();
        SomeDataService someDataService = mock(SomeDataService.class);
        businessImpl.setSomeDataService(someDataService);
        when(someDataService.getAllData()).thenReturn(new int[] {1, 2, 3});
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void calculateSum_dataService_empty() {
        BusinessImpl businessImpl = new BusinessImpl();
        SomeDataService someDataService = mock(SomeDataService.class);
        businessImpl.setSomeDataService(someDataService);
        when(someDataService.getAllData()).thenReturn(new int[] {});
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void storeSumTest() {
        BusinessImpl businessImpl = new BusinessImpl();
        SomeDataService someDataService = mock(SomeDataService.class);
        businessImpl.setSomeDataService(someDataService);
        when(someDataService.getAllData()).thenReturn(new int[] {1, 2, 3});
        businessImpl.storeSum();
        verify(someDataService).storeData(6);
    }

    @Test
    public void storeSumTest_captor() {
        BusinessImpl businessImpl = new BusinessImpl();
        SomeDataService someDataService = mock(SomeDataService.class);
        businessImpl.setSomeDataService(someDataService);
        when(someDataService.getAllData()).thenReturn(new int[] {1, 2, 3});
        businessImpl.storeSum();
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(someDataService).storeData(captor.capture());
        assertEquals(6, captor.getValue());
    }

    @Test
    public void storeSumTest_captorMultiple() {
        BusinessImpl businessImpl = new BusinessImpl();
        SomeDataService someDataService = mock(SomeDataService.class);
        businessImpl.setSomeDataService(someDataService);
        when(someDataService.getAllData()).thenReturn(new int[] {1, 2, 3})
                .thenReturn(new int[] {5});
        businessImpl.storeSum();
        businessImpl.storeSum();
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        verify(someDataService, times(2)).storeData(captor.capture());
        List<Integer> allValues = captor.getAllValues();
        assertEquals(6, allValues.get(0));
        assertEquals(5, allValues.get(1));
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("test");
        when(arrayListSpy.size()).thenReturn(5)
        .thenReturn(6);
        System.out.println(arrayListSpy.size());
        System.out.println(arrayListSpy.size());
        System.out.println(arrayListSpy.size());
        System.out.println(arrayListSpy.size());
    }
}
