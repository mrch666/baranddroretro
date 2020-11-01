package ru.specinstrument.instrumentstore.modelgoods.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ModelgoodsList implements List<Modelgoods> {


    public ModelgoodsList(List<Modelgoods> modelgoodsList) {
        this.modelgoodsList = modelgoodsList;
    }

    public List<Modelgoods> getModelgoodsList() {
        return modelgoodsList;
    }

    public void setModelgoodsList(List<Modelgoods> modelgoodsList) {
        this.modelgoodsList = modelgoodsList;
    }
@Expose
    private List<Modelgoods> modelgoodsList = null;


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Modelgoods> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(Modelgoods modelgoods) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Modelgoods> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends Modelgoods> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Modelgoods get(int i) {
        return null;
    }

    @Override
    public Modelgoods set(int i, Modelgoods modelgoods) {
        return null;
    }

    @Override
    public void add(int i, Modelgoods modelgoods) {

    }

    @Override
    public Modelgoods remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<Modelgoods> listIterator() {
        return null;
    }

    @NonNull
    @Override
    public ListIterator<Modelgoods> listIterator(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<Modelgoods> subList(int i, int i1) {
        return null;
    }
}