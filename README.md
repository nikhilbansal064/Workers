# Workers
Overview : It is a simple application showing list of workers in different form given API url to get data.

Application features:
1. Application shows workers list in following two format in different tabs
    1. Simple List - shows name of workers in a recycler view
    2. Section list - show name of workers categorised by their role in expandable list view
2. Retrofit Library is used for background Api calling  and data(JSON) parsing.
3. UI is created using constraint layouts.
4. UI (view controllers) and their respective adapters are created in Kotlin.
    1. WorkerList( recycler view and its adapter) are created in java as it falls under first part as mentioned in Refrence Doc.
5. Tab layout with view pager with fragments are used to  different lists.
6. Background api calling and data module is developed in java.
7. Project is well structured in following parts - 
    1. view - contains all view controllers and UI responsibility.
    2. adapters - contains adapters for respective screens.
    3. api - responsible for api request and response parsing.
    4. data_model - contains all data classes to stored api response.
