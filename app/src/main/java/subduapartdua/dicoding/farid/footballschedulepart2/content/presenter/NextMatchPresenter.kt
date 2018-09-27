package subduapartdua.dicoding.farid.footballschedulepart2.content.presenter

import io.reactivex.disposables.CompositeDisposable
import subduapartdua.dicoding.farid.footballschedulepart2.content.view.MatchView
import subduapartdua.dicoding.farid.footballschedulepart2.model.MatchFunction
import subduapartdua.dicoding.farid.footballschedulepart2.utils.SchedulerProvider

class NextMatchPresenter(val matchView: MatchView.View,
                     val matchFunction: MatchFunction,
                     val scheduler: SchedulerProvider) : MatchView.Presenter {

    val compositeDisposable = CompositeDisposable()

    override fun getMatchFootball() {
        compositeDisposable.add(matchFunction.getUpcomingMatch("4328")
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe {
                    matchView.displayMatchFootball(it.eventResponses)
                })
    }
}