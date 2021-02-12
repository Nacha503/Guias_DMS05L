package sv.edu.udb.guia3_discusion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    public MutableLiveData<Integer> currentNumber;
    public MutableLiveData<Boolean> currentState;
//    public Integer number = 0;


    public LiveData<Integer> getNumero() {
        if(currentNumber == null){
            currentNumber = new MutableLiveData<Integer>();
            currentNumber.setValue(0);
        }
        return currentNumber;
    }

    public LiveData<Boolean> getState() {
        if(currentState == null){
            currentState = new MutableLiveData<Boolean>();
        }
        return currentState;
    }



    public void Incrementar(){
        if(currentNumber.getValue()!= null){
            currentNumber.setValue(currentNumber.getValue()+1);
        }
    }

    public void Reset(){
        if(currentNumber.getValue()!= null){
            currentNumber.setValue(0);
        }
    }



}
