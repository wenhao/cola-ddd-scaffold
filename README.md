# cola-dddd-scaffold

包结构及用途:

1. adapter.<aggregate-name>.web: RESTful API.
2. application.<aggregate-name>.executor: 应用服务.
3. domain.<aggregate-name>.model: 实体、值对象.
4. domain.<aggregate-name>.ability: 领域服务.
5. domain.<aggregate-name>.gateway: 领域网关.
6. infrastructure.<aggregate-name>.gatewayimpl: 网关实现.
7. infrastructure.<aggregate-name>.mapper: myBatis数据库映射.
8. infrastructure.<aggregate-name>.config: 配置信息.

概念解释:

1. 应用服务（Application Service）：组织业务场景，编排业务，隔离场景对领域层的差异。不提供领域实现，也不包含业务逻辑。粒度较粗，不能被复用。
2. 领域服务（Domain Service）：多个聚合的协作，目的是使用聚合内的实体和值对象编排业务逻辑。粒度较细，便于复用。为了更少的领域逻辑被分散到领域服务，强制在领域服务命名时加上动词。
3. 领域对象（Domain Model）：实现具体的业务逻辑、规则，为应用层提供无差别的服务能力。
4. 基础设施（Infrastructure）：提供具体的技术实现，比如数据库存储、缓存、消息，基础设施对业务保持透明。
5. 聚合（Aggregate）：是一组生命周期强一致，修改规则强关联的实体和值对象的集合，表达统一的业务意义。
6. 聚合根（ Aggregate Root）：是聚合中最核心的实体，其他的实体和值对象都从属于这个实体。
7. 仓储（Repository）：是以持久化领域模型为职责的类，只有聚合根才能拥有Repository，Repository管理领域对象的生命周期并屏蔽数据库的实现。
8. 工厂（Factory）：是以构建领域模型（实体或值对象）为职责的类或方法。负责聚合实例的生，垃圾回收负责聚合实例的死。

### 建模案例

![订单领域建模](./docs/订单模型关系图.png)

### 需求

实现订单上下文。

### DDD战术

![DDD战术](./docs/DDD战术.png)
