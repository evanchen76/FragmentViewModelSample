package evan.chen.tutorial.fragmentviewmodelsample.ui.main

import androidx.lifecycle.*
import evan.chen.tutorial.fragmentviewmodelsample.Event

class MainViewModel : ViewModel() {
    var listLiveData: MutableLiveData<List<Item>> = MutableLiveData()
    var selected: MutableLiveData<Item> = MutableLiveData()
    var openItemEvent: MutableLiveData<Event<Item>> = MutableLiveData()

    var detailString: MutableLiveData<String> = MutableLiveData()

    init {
        val list = mutableListOf<Item>()
        (1..20).forEach {
            list.add(Item("Text $it"))
        }

        listLiveData.value = list
    }

    fun openItem(item: Item) {
        selected.value = item
        openItemEvent.value = Event(item)
    }
}
