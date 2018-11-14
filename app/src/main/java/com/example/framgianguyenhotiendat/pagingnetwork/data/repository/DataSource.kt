package com.example.framgianguyenhotiendat.pagingnetwork.data.repository

import com.example.framgianguyenhotiendat.pagingnetwork.data.source.local.LocalDataSource
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.RemoteDatsource

interface DataSource : LocalDataSource, RemoteDatsource