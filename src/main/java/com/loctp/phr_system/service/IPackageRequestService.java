package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.PackageRequestClient;

import java.util.List;

public interface IPackageRequestService {
    Boolean creatPackageRequest(List<PackageRequestClient> packageRequestClients);
}
