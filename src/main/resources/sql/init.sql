create table drug_manual
(
    id                       int primary key not null auto_increment,
    drug_name                text            not null comment '药品名称',
    manual_source            varchar(255) default null comment '来源',
    images_url               text         default null comment '图片',
    composition              text         default null comment '成分',
    injections               text         default null comment '注射剂辅料',
    nature                   text         default null comment '性状',
    indication               text         default null comment '适应症',
    pharmacology             text         default null comment '药理毒理',
    pharmacokinetics         text         default null comment '药代动力学',
    dosage                   text         default null comment '用法用量',
    specification            text         default null comment '规格',
    role_category            text         default null comment '作用类别',
    adverse_reactions        text         default null comment '不良反应',
    taboo                    text         default null comment '禁忌',
    precautions              text         default null comment '注意事项',
    pregnant_woman           text         default null comment '孕妇及哺乳期妇女用药',
    child                    text         default null comment '儿童用药',
    elderly                  text         default null comment '老年患者用药',
    interaction              text         default null comment '药物相互作用',
    drug_overdose            text         default null comment '药物过量',
    store                    text         default null comment '贮藏',
    pack                     text         default null comment '包装',
    expiration_date          text default null comment '有效期',
    implementation_standards text default null comment '执行标准',
    ratify_number            text         default null comment '批准文号',
    company                  text         default null comment '生产企业'
) comment '药品说明书' charset = utf8mb4;