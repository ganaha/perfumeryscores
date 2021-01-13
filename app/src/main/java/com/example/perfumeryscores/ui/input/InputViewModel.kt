package com.example.perfumeryscores.ui.input

import androidx.lifecycle.*
import com.example.perfumeryscores.AppRepository
import com.example.perfumeryscores.db.History
import com.example.perfumeryscores.db.Player
import com.example.perfumeryscores.db.Score
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class InputViewModel(private val repository: AppRepository) : ViewModel() {

    val players: LiveData<List<Player>> = repository.players.asLiveData()

    private fun insertScore(score: Score) {
        viewModelScope.launch {
            repository.insertScore(score)
        }
    }

    // name
    val nameP1: MutableLiveData<String> = MutableLiveData("")
    val nameP2: MutableLiveData<String> = MutableLiveData("")
    val nameP3: MutableLiveData<String> = MutableLiveData("")
    val nameP4: MutableLiveData<String> = MutableLiveData("")

    // P1

    // P1 - count

    private val _count2P1 = MutableLiveData(0)
    val count2P1 = _count2P1

    private val _count3P1 = MutableLiveData(0)
    val count3P1 = _count3P1

    private val _count4P1 = MutableLiveData(0)
    val count4P1 = _count4P1

    private val _count7P1 = MutableLiveData(0)
    val count7P1 = _count7P1

    private val _count8P1 = MutableLiveData(0)
    val count8P1 = _count8P1

    private val _count14P1 = MutableLiveData(0)
    val count14P1 = _count14P1

    private val _count15P1 = MutableLiveData(0)
    val count15P1 = _count15P1

    // P1 - subtotal

    private val sub2P1 = Transformations.map(_count2P1) {
        2 * it
    }

    private val sub3P1 = Transformations.map(_count3P1) {
        3 * it
    }

    private val sub4P1 = Transformations.map(_count4P1) {
        4 * it
    }

    private val sub7P1 = Transformations.map(_count7P1) {
        7 * it
    }

    private val sub8P1 = Transformations.map(_count8P1) {
        8 * it
    }

    private val sub14P1 = Transformations.map(_count14P1) {
        14 * it
    }

    private val sub15P1 = Transformations.map(_count15P1) {
        15 * it
    }

    // P1 - total

    val totalP1: MediatorLiveData<Int> = MediatorLiveData<Int>()

    // P1 - click

    fun onClick2P1() {
        _count2P1.value = _count2P1.value?.inc()
    }

    fun onClick3P1() {
        _count3P1.value = _count3P1.value?.inc()
    }

    fun onClick4P1() {
        _count4P1.value = _count4P1.value?.inc()
    }

    fun onClick7P1() {
        _count7P1.value = _count7P1.value?.inc()
    }

    fun onClick8P1() {
        _count8P1.value = _count8P1.value?.inc()
    }

    fun onClick14P1() {
        _count14P1.value = _count14P1.value?.inc()
    }

    fun onClick15P1() {
        _count15P1.value = _count15P1.value?.inc()
    }

    fun onClickClearP1() {
        listOf(
            _count2P1,
            _count3P1,
            _count4P1,
            _count7P1,
            _count8P1,
            _count14P1,
            _count15P1
        ).forEach { it.value = 0 }
    }

    // P2

    // P2 - count

    private val _count2P2 = MutableLiveData(0)
    val count2P2 = _count2P2

    private val _count3P2 = MutableLiveData(0)
    val count3P2 = _count3P2

    private val _count4P2 = MutableLiveData(0)
    val count4P2 = _count4P2

    private val _count7P2 = MutableLiveData(0)
    val count7P2 = _count7P2

    private val _count8P2 = MutableLiveData(0)
    val count8P2 = _count8P2

    private val _count14P2 = MutableLiveData(0)
    val count14P2 = _count14P2

    private val _count15P2 = MutableLiveData(0)
    val count15P2 = _count15P2

    // P2 - subtotal

    private val sub2P2 = Transformations.map(_count2P2) {
        2 * it
    }

    private val sub3P2 = Transformations.map(_count3P2) {
        3 * it
    }

    private val sub4P2 = Transformations.map(_count4P2) {
        4 * it
    }

    private val sub7P2 = Transformations.map(_count7P2) {
        7 * it
    }

    private val sub8P2 = Transformations.map(_count8P2) {
        8 * it
    }

    private val sub14P2 = Transformations.map(_count14P2) {
        14 * it
    }

    private val sub15P2 = Transformations.map(_count15P2) {
        15 * it
    }

    // P2 - total

    val totalP2: MediatorLiveData<Int> = MediatorLiveData<Int>()


    // P2 - click

    fun onClick2P2() {
        _count2P2.value = _count2P2.value?.inc()
    }

    fun onClick3P2() {
        _count3P2.value = _count3P2.value?.inc()
    }

    fun onClick4P2() {
        _count4P2.value = _count4P2.value?.inc()
    }

    fun onClick7P2() {
        _count7P2.value = _count7P2.value?.inc()
    }

    fun onClick8P2() {
        _count8P2.value = _count8P2.value?.inc()
    }

    fun onClick14P2() {
        _count14P2.value = _count14P2.value?.inc()
    }

    fun onClick15P2() {
        _count15P2.value = _count15P2.value?.inc()
    }

    fun onClickClearP2() {
        listOf(
            _count2P2,
            _count3P2,
            _count4P2,
            _count7P2,
            _count8P2,
            _count14P2,
            _count15P2
        ).forEach { it.value = 0 }
    }

    // P3

    // P3 - count

    private val _count2P3 = MutableLiveData(0)
    val count2P3 = _count2P3

    private val _count3P3 = MutableLiveData(0)
    val count3P3 = _count3P3

    private val _count4P3 = MutableLiveData(0)
    val count4P3 = _count4P3

    private val _count7P3 = MutableLiveData(0)
    val count7P3 = _count7P3

    private val _count8P3 = MutableLiveData(0)
    val count8P3 = _count8P3

    private val _count14P3 = MutableLiveData(0)
    val count14P3 = _count14P3

    private val _count15P3 = MutableLiveData(0)
    val count15P3 = _count15P3

    // P3 - subtotal

    private val sub2P3 = Transformations.map(_count2P3) {
        2 * it
    }

    private val sub3P3 = Transformations.map(_count3P3) {
        3 * it
    }

    private val sub4P3 = Transformations.map(_count4P3) {
        4 * it
    }

    private val sub7P3 = Transformations.map(_count7P3) {
        7 * it
    }

    private val sub8P3 = Transformations.map(_count8P3) {
        8 * it
    }

    private val sub14P3 = Transformations.map(_count14P3) {
        14 * it
    }

    private val sub15P3 = Transformations.map(_count15P3) {
        15 * it
    }

    // P3 - total

    val totalP3: MediatorLiveData<Int> = MediatorLiveData<Int>()


    // P3 - click

    fun onClick2P3() {
        _count2P3.value = _count2P3.value?.inc()
    }

    fun onClick3P3() {
        _count3P3.value = _count3P3.value?.inc()
    }

    fun onClick4P3() {
        _count4P3.value = _count4P3.value?.inc()
    }

    fun onClick7P3() {
        _count7P3.value = _count7P3.value?.inc()
    }

    fun onClick8P3() {
        _count8P3.value = _count8P3.value?.inc()
    }

    fun onClick14P3() {
        _count14P3.value = _count14P3.value?.inc()
    }

    fun onClick15P3() {
        _count15P3.value = _count15P3.value?.inc()
    }

    fun onClickClearP3() {
        listOf(
            _count2P3,
            _count3P3,
            _count4P3,
            _count7P3,
            _count8P3,
            _count14P3,
            _count15P3
        ).forEach { it.value = 0 }
    }

    // P4

    // P4 - count

    private val _count2P4 = MutableLiveData(0)
    val count2P4 = _count2P4

    private val _count3P4 = MutableLiveData(0)
    val count3P4 = _count3P4

    private val _count4P4 = MutableLiveData(0)
    val count4P4 = _count4P4

    private val _count7P4 = MutableLiveData(0)
    val count7P4 = _count7P4

    private val _count8P4 = MutableLiveData(0)
    val count8P4 = _count8P4

    private val _count14P4 = MutableLiveData(0)
    val count14P4 = _count14P4

    private val _count15P4 = MutableLiveData(0)
    val count15P4 = _count15P4

    // P4 - subtotal

    private val sub2P4 = Transformations.map(_count2P4) {
        2 * it
    }

    private val sub3P4 = Transformations.map(_count3P4) {
        3 * it
    }

    private val sub4P4 = Transformations.map(_count4P4) {
        4 * it
    }

    private val sub7P4 = Transformations.map(_count7P4) {
        7 * it
    }

    private val sub8P4 = Transformations.map(_count8P4) {
        8 * it
    }

    private val sub14P4 = Transformations.map(_count14P4) {
        14 * it
    }

    private val sub15P4 = Transformations.map(_count15P4) {
        15 * it
    }

    // P4 - total

    val totalP4: MediatorLiveData<Int> = MediatorLiveData<Int>()


    // P4 - click

    fun onClick2P4() {
        _count2P4.value = _count2P4.value?.inc()
    }

    fun onClick3P4() {
        _count3P4.value = _count3P4.value?.inc()
    }

    fun onClick4P4() {
        _count4P4.value = _count4P4.value?.inc()
    }

    fun onClick7P4() {
        _count7P4.value = _count7P4.value?.inc()
    }

    fun onClick8P4() {
        _count8P4.value = _count8P4.value?.inc()
    }

    fun onClick14P4() {
        _count14P4.value = _count14P4.value?.inc()
    }

    fun onClick15P4() {
        _count15P4.value = _count15P4.value?.inc()
    }

    fun onClickClearP4() {
        listOf(
            _count2P4,
            _count3P4,
            _count4P4,
            _count7P4,
            _count8P4,
            _count14P4,
            _count15P4
        ).forEach { it.value = 0 }
    }

    // addSource

    private fun addSources(total: MediatorLiveData<Int>, vararg subtotals: LiveData<Int>) {
        val sum = Observer<Int> {
            total.value = subtotals.sumBy { it.value ?: 0 }
        }
        total.apply {
            subtotals.forEach { addSource(it, sum) }
        }
    }

    init {
        addSources(totalP1, sub2P1, sub3P1, sub4P1, sub7P1, sub8P1, sub14P1, sub15P1)
        addSources(totalP2, sub2P2, sub3P2, sub4P2, sub7P2, sub8P2, sub14P2, sub15P2)
        addSources(totalP3, sub2P3, sub3P3, sub4P3, sub7P3, sub8P3, sub14P3, sub15P3)
        addSources(totalP4, sub2P4, sub3P4, sub4P4, sub7P4, sub8P4, sub14P4, sub15P4)
    }

    // Save
    fun onClickSave() {
        viewModelScope.launch {
            // get player id
            val p1Name = nameP1.value ?: ""
            val p2Name = nameP2.value ?: ""
            val p3Name = nameP3.value ?: ""
            val p4Name = nameP4.value ?: ""

            val p1PlayerId = getPlayerId(p1Name)
            val p2PlayerId = getPlayerId(p2Name)
            val p3PlayerId = getPlayerId(p3Name)
            val p4PlayerId = getPlayerId(p4Name)

            // insert history
            val historyId = repository.insertHistory(History(null))

            // insert score
            val p1Total = totalP1.value ?: 0
            val p2Total = totalP2.value ?: 0
            val p3Total = totalP3.value ?: 0
            val p4Total = totalP4.value ?: 0

            val p1Rank = getRank(p1Total, p2Total, p3Total, p4Total)
            val p2Rank = getRank(p2Total, p1Total, p3Total, p4Total)
            val p3Rank = getRank(p3Total, p1Total, p2Total, p4Total)
            val p4Rank = getRank(p4Total, p1Total, p2Total, p3Total)

            p1PlayerId?.let { insertScore(Score(null, it, historyId, p1Total, p1Rank)) }
            p2PlayerId?.let { insertScore(Score(null, it, historyId, p2Total, p2Rank)) }
            p3PlayerId?.let { insertScore(Score(null, it, historyId, p3Total, p3Rank)) }
            p4PlayerId?.let { insertScore(Score(null, it, historyId, p4Total, p4Rank)) }
        }
    }

    /**
     * 順位を算出する。
     */
    private fun getRank(myTotal: Int, vararg totals: Int): Int {
        val list = listOf(myTotal, *totals.toTypedArray())
        val sorted = list.sortedDescending()
        return sorted.indexOf(myTotal) + 1
    }

    /**
     * nameからplayer_idを取得する。なければ新規登録。
     */
    private fun getPlayerId(name: String): Long? {
        if (name.isBlank()) return null

        var playerId = -1L
        runBlocking {
            val player = repository.getPlayerByName(name)
            playerId = player?.id ?: repository.insertPlayer(Player(null, name))
        }
        return playerId
    }
}

class InputViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InputViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InputViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}