package subduapartdua.dicoding.farid.footballschedulepart2.content.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import subduapartdua.dicoding.farid.footballschedulepart2.content.view.DetailMatchView
import subduapartdua.dicoding.farid.footballschedulepart2.model.MatchFunction

class DetailPresenter(val mView : DetailMatchView.View, val matchFunction: MatchFunction) : DetailMatchView.Presenter {

    override fun getLogoHome(id: String) {
        compositeDisposable.add(matchFunction.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayLogoHome(it.team[0])
                })
    }

    val compositeDisposable = CompositeDisposable()

    override fun getLogoAway(id:String) {
        compositeDisposable.add(matchFunction.getTeams(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                    mView.displayLogoAway(it.team[0])
                })
    }
}