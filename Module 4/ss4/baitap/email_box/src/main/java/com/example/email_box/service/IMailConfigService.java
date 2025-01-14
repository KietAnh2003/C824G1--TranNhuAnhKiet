package com.example.email_box.service;

import com.example.email_box.model.MailConfig;

public interface IMailConfigService {
    public MailConfig getConfig();

    public void updateConfig(MailConfig newConfig);
}
